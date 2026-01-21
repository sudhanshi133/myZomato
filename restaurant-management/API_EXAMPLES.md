# Restaurant Service API Examples

## Prerequisites
1. MongoDB running on `localhost:27017`
2. Application running on `http://localhost:8080`

## API Endpoints

### 1. Create Restaurant
```bash
curl -X POST http://localhost:8080/restaurants \
  -H "Content-Type: application/json" \
  -H "X-TENANT-ID: tenant1" \
  -d '{
    "id": "dominos-sector18",
    "location": "Sector 18, Noida",
    "open": true
  }'
```

**Response (201 Created):**
```json
{
  "id": "dominos-sector18",
  "tenantId": "tenant1",
  "location": "Sector 18, Noida",
  "open": true,
  "createdAt": "2026-01-21T10:30:00Z"
}
```

### 2. Get Restaurant by ID
```bash
curl -X GET http://localhost:8080/restaurants/dominos-sector18 \
  -H "X-TENANT-ID: tenant1"
```

**Response (200 OK):**
```json
{
  "id": "dominos-sector18",
  "tenantId": "tenant1",
  "location": "Sector 18, Noida",
  "open": true,
  "createdAt": "2026-01-21T10:30:00Z"
}
```

### 3. List All Restaurants for a Tenant
```bash
curl -X GET http://localhost:8080/restaurants \
  -H "X-TENANT-ID: tenant1"
```

**Response (200 OK):**
```json
[
  {
    "id": "dominos-sector18",
    "tenantId": "tenant1",
    "location": "Sector 18, Noida",
    "open": true,
    "createdAt": "2026-01-21T10:30:00Z"
  },
  {
    "id": "kfc-sector62",
    "tenantId": "tenant1",
    "location": "Sector 62, Noida",
    "open": false,
    "createdAt": "2026-01-21T11:00:00Z"
  }
]
```

### 4. Update Restaurant Status
```bash
curl -X PUT http://localhost:8080/restaurants/dominos-sector18/status \
  -H "Content-Type: application/json" \
  -H "X-TENANT-ID: tenant1" \
  -d '{
    "open": false
  }'
```

**Response (200 OK):**
```json
{
  "id": "dominos-sector18",
  "tenantId": "tenant1",
  "location": "Sector 18, Noida",
  "open": false,
  "createdAt": "2026-01-21T10:30:00Z"
}
```

## Multi-Tenancy Testing

### Test 1: Create restaurants for different tenants
```bash
# Tenant 1
curl -X POST http://localhost:8080/restaurants \
  -H "Content-Type: application/json" \
  -H "X-TENANT-ID: tenant1" \
  -d '{"id": "restaurant1", "location": "Location 1", "open": true}'

# Tenant 2
curl -X POST http://localhost:8080/restaurants \
  -H "Content-Type: application/json" \
  -H "X-TENANT-ID: tenant2" \
  -d '{"id": "restaurant2", "location": "Location 2", "open": true}'
```

### Test 2: Verify tenant isolation
```bash
# Tenant 1 trying to access Tenant 2's restaurant (should return 404)
curl -X GET http://localhost:8080/restaurants/restaurant2 \
  -H "X-TENANT-ID: tenant1"
```

**Response (404 Not Found):**
```json
{
  "status": 404,
  "message": "Restaurant not found with id: restaurant2 for tenant: tenant1",
  "timestamp": "2026-01-21T10:35:00Z"
}
```

## Error Scenarios

### Missing X-TENANT-ID Header
```bash
curl -X GET http://localhost:8080/restaurants/dominos-sector18
```

**Response (400 Bad Request):**
```json
{
  "status": 400,
  "message": "Required header 'X-TENANT-ID' is missing",
  "timestamp": "2026-01-21T10:40:00Z"
}
```

### Validation Error
```bash
curl -X POST http://localhost:8080/restaurants \
  -H "Content-Type: application/json" \
  -H "X-TENANT-ID: tenant1" \
  -d '{
    "location": "Sector 18, Noida"
  }'
```

**Response (400 Bad Request):**
```json
{
  "status": 400,
  "errors": {
    "id": "Restaurant ID is required",
    "open": "Open status is required"
  },
  "timestamp": "2026-01-21T10:45:00Z"
}
```

## Running the Application

1. Start MongoDB:
```bash
mongod
```

2. Build and run the application:
```bash
cd restaurant-management
./mvnw clean install
./mvnw spring-boot:run
```

3. The application will start on `http://localhost:8080`


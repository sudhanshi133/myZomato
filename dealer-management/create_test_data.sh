#!/bin/bash

BASE_URL="http://localhost:8081"

echo "Creating dealers and tenants..."
echo "================================"

# Dealer 1: FoodCorp with 5 tenants (SHARED)
echo -e "\n1. Creating FoodCorp dealer..."
curl -s -X POST $BASE_URL/dealers -H "Content-Type: application/json" -d '{"dealerId": "foodcorp"}' | jq .

echo "   Creating tenants for FoodCorp..."
curl -s -X POST $BASE_URL/dealers/foodcorp/tenants -H "Content-Type: application/json" -d '{"tenantId": "dominos", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/foodcorp/tenants -H "Content-Type: application/json" -d '{"tenantId": "pizzahut", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/foodcorp/tenants -H "Content-Type: application/json" -d '{"tenantId": "subway", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/foodcorp/tenants -H "Content-Type: application/json" -d '{"tenantId": "kfc", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/foodcorp/tenants -H "Content-Type: application/json" -d '{"tenantId": "burgerking", "dbType": "SHARED"}' | jq .

# Dealer 2: QuickBites with 4 tenants (SHARED)
echo -e "\n2. Creating QuickBites dealer..."
curl -s -X POST $BASE_URL/dealers -H "Content-Type: application/json" -d '{"dealerId": "quickbites"}' | jq .

echo "   Creating tenants for QuickBites..."
curl -s -X POST $BASE_URL/dealers/quickbites/tenants -H "Content-Type: application/json" -d '{"tenantId": "tacobell", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/quickbites/tenants -H "Content-Type: application/json" -d '{"tenantId": "wendys", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/quickbites/tenants -H "Content-Type: application/json" -d '{"tenantId": "chipotle", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/quickbites/tenants -H "Content-Type: application/json" -d '{"tenantId": "pandaexpress", "dbType": "SHARED"}' | jq .

# Dealer 3: GlobalEats with 5 tenants (SHARED)
echo -e "\n3. Creating GlobalEats dealer..."
curl -s -X POST $BASE_URL/dealers -H "Content-Type: application/json" -d '{"dealerId": "globaleats"}' | jq .

echo "   Creating tenants for GlobalEats..."
curl -s -X POST $BASE_URL/dealers/globaleats/tenants -H "Content-Type: application/json" -d '{"tenantId": "mcdonalds", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/globaleats/tenants -H "Content-Type: application/json" -d '{"tenantId": "starbucks", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/globaleats/tenants -H "Content-Type: application/json" -d '{"tenantId": "dunkindonuts", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/globaleats/tenants -H "Content-Type: application/json" -d '{"tenantId": "fiveguys", "dbType": "SHARED"}' | jq .
curl -s -X POST $BASE_URL/dealers/globaleats/tenants -H "Content-Type: application/json" -d '{"tenantId": "shakeshack", "dbType": "SHARED"}' | jq .

# Dealer 4: MegaChain with 1 large tenant (DEDICATED)
echo -e "\n4. Creating MegaChain dealer..."
curl -s -X POST $BASE_URL/dealers -H "Content-Type: application/json" -d '{"dealerId": "megachain"}' | jq .

echo "   Creating large tenant for MegaChain..."
curl -s -X POST $BASE_URL/dealers/megachain/tenants -H "Content-Type: application/json" -d '{"tenantId": "walmartcafe", "dbType": "DEDICATED"}' | jq .

# Dealer 5: EnterpriseFood with 1 large tenant (DEDICATED)
echo -e "\n5. Creating EnterpriseFood dealer..."
curl -s -X POST $BASE_URL/dealers -H "Content-Type: application/json" -d '{"dealerId": "enterprisefood"}' | jq .

echo "   Creating large tenant for EnterpriseFood..."
curl -s -X POST $BASE_URL/dealers/enterprisefood/tenants -H "Content-Type: application/json" -d '{"tenantId": "amazonfresh", "dbType": "DEDICATED"}' | jq .

echo -e "\n================================"
echo "Test data creation completed!"
echo "================================"

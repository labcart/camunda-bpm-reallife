#!/usr/bin/env bash
#!/usr/bin/env bash
X_CURRENT_PATH=$(pwd)

for X in order-service payment-service camunda-admin-dashboard-service
do
    cd ${X_CURRENT_PATH}/${X}
    mvn clean install dockerfile:build -DskipTests
done
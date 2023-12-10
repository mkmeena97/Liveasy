# Liveasy
# Load Management System
This is a simple Load Management System API that allows users to manage and retrieve load details using PostgreSQL.

## Functionality

1. **Add Load Details:**
   - **Endpoint:** POST "/load"
   - **Payload:** { ... }
   - **Response:** "Loads details added successfully"

2. **Retrieve Loads:**
   - **Endpoint:** GET "/load"
   - **Query Params:** shipperId
   - **Response:** List of loads with the specified shipperId

3. **Manage Load:**
   - **Retrieve Load:**
     - **Endpoint:** GET "/load/{loadId}"
     - **Response:** Load details for the specified loadId

   - **Update Load:**
     - **Endpoint:** PUT "/load/{loadId}"
     - **Payload:** { ... }

   - **Delete Load:**
     - **Endpoint:** DELETE "/load/{loadId}"


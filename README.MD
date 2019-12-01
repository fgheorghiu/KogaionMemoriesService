### DiGiX Memories Service

keycloak-host=<your_host_for_keycloak>

admin-role=<your_admin_role_in_keycloak>

The following properties need to be set up in order to run the Memories Service:

| Property | Value | Info |
|---|---|---|
|keycloak.auth-server-url|KEYCLOAK-HOST/auth|   |
|keycloak.realm|master|   |
|keycloak.resource|client_id|   |
|keycloak.public-client|true|   |
|keycloak.principal-attribute|preferred_username|   |
|keycloak.security-constraints[0].authRoles[0]|admin-role|   |
|keycloak.security-constraints[0].securityCollections[0].patterns[0]|url_root_path||
|---|---|---|
|spring.main.allow-bean-definition-overriding|true|   |
|spring.datasource.url|url_to_db|   |
|spring.datasource.driverClassName|driver_for_db|   |
|spring.datasource.username|username_for_db|   |
|spring.datasource.password|password_for_db|   |
|spring.jpa.database-platform|dialect_for_db|   |
|spring.h2.console.enabled|true|Enable admin console for H2 database (if it's used)|
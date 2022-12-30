CREATE DATABASE familieheist;
GRANT ALL PRIVILEGES ON DATABASE familieheist TO localdev;
\c familieheist;
GRANT ALL ON SCHEMA public TO localdev;

CREATE DATABASE keycloak;
GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;
\c keycloak;
GRANT ALL ON SCHEMA public TO keycloak;

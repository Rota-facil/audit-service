CREATE TABLE IF NOT EXISTS audit_tb (
    audit_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    role VARCHAR(20) NOT NULL,
    action_title TEXT NOT NULL,
    action_type VARCHAR(30) NOT NULL,
    resource_name VARCHAR(40) NOT NULL,
    resource_id UUID NOT NULL

)
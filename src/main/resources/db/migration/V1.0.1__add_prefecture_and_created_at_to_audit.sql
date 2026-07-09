ALTER TABLE audit_tb
    ADD COLUMN IF NOT EXISTS prefecture_id UUID;

ALTER TABLE audit_tb
    ADD COLUMN IF NOT EXISTS created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

CREATE INDEX IF NOT EXISTS idx_audit_prefecture_created_at
    ON audit_tb (prefecture_id, created_at DESC);

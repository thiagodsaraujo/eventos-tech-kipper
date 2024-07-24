CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE address (
                       id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                       city VARCHAR(100) NOT NULL,
                       uf VARCHAR(2) NOT NULL,
                       event_id UUID,
                          foreign key (event_id) references event(id) ON DELETE CASCADE
);

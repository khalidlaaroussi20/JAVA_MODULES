-- noinspection SqlDialectInspectionForFile

CREATE TABLE IF NOT EXISTS "users"
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS rooms
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    owner INTEGER REFERENCES "users" (id)
);

CREATE TABLE IF NOT EXISTS "users_rooms"
(
    user_id INTEGER REFERENCES "users" (id),
    Room_id INTEGER REFERENCES rooms (id)
);

CREATE TABLE IF NOT EXISTS messages
(
    id SERIAL PRIMARY KEY,
    text VARCHAR(200) NOT NULL,
    datetime timestamp,
    author INTEGER REFERENCES "users" (id),
    room INTEGER REFERENCES rooms (id)
);
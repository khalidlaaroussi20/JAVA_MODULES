-- noinspection SqlDialectInspectionForFile

CREATE TABLE IF NOT EXISTS "User"
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS Room
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    owner INTEGER REFERENCES "User" (id)
)

CREATE TABLE IF NOT EXISTS "User_Room"
(
    user_id INTEGER REFERENCES "User" (id),
    Room_id INTEGER REFERENCES Room (id)
)

CREATE TABLE IF NOT EXISTS Message
(
    id SERIAL PRIMARY KEY,
    text VARCHAR(200) NOT NULL,
    datetime timestamp,
    author INTEGER REFERENCES "User" (id),
    room INTEGER REFERENCES Room (id)
)
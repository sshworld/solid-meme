CREATE TABLE users
(
    id            VARCHAR(20) PRIMARY KEY,
    password      VARCHAR(100) NOT NULL,
    nickname      VARCHAR(50)  NOT NULL,
    `name`        VARCHAR(50)  NOT NULL,
    mobile_number VARCHAR(20)  NOT NULL,
    email         VARCHAR(30)  NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP
);

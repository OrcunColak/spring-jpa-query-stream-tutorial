CREATE TABLE Company (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255),
    company_id BIGINT,
    CONSTRAINT fk_company
      FOREIGN KEY(company_id)
	  REFERENCES Company(id)
);

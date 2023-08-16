USE currency_conversion;

DROP TABLE IF EXISTS exchange_rate;

CREATE TABLE exchange_rate (
	id INT NOT NULL AUTO_INCREMENT,
    source_currency varchar(45) NOT NULL,
    target_currency varchar(45) NOT NULL,
    conversion_multiple double(5,2) NOT NULL,
    PRIMARY KEY(ID)
)ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = latin1;

INSERT INTO exchange_rate(source_currency, target_currency, conversion_multiple) 
	VALUES('USD', 'INR', 80);
INSERT INTO exchange_rate(source_currency, target_currency, conversion_multiple) 
	VALUES('EUR', 'INR', 100);
INSERT INTO exchange_rate(source_currency, target_currency, conversion_multiple) 
	VALUES('AUD', 'INR', 75);
INSERT INTO exchange_rate(source_currency, target_currency, conversion_multiple) 
	VALUES('BP', 'INR', 95);
    
select  * from exchange_rate;
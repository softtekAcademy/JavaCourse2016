CREATE TABLE omsdb.order_status
(
	status_code          CHAR(03) NOT NULL,
	description          VARCHAR(10) NOT NULL
);

ALTER TABLE omsdb.order_status
ADD PRIMARY KEY (status_code);

CREATE TABLE omsdb.sales_channel
(
	channel_code         CHAR(03) NOT NULL,
	description          VARCHAR(20) NULL
);

ALTER TABLE omsdb.sales_channel
ADD PRIMARY KEY (channel_code);

CREATE TABLE omsdb.sales_order
(
	order_id             VARCHAR(36) NOT NULL,
	date_created         DATE NOT NULL,
	status_code          CHAR(03) NOT NULL,
	channel_code         CHAR(03) NULL
);

ALTER TABLE omsdb.sales_order
ADD PRIMARY KEY (order_id);

CREATE INDEX XIF1Order ON omsdb.sales_order
(
	status_code ASC
);

CREATE INDEX XIF2Order ON omsdb.sales_order
(
	channel_code ASC
);

ALTER TABLE omsdb.sales_order
ADD CONSTRAINT FK1sales_order FOREIGN KEY (status_code) REFERENCES omsdb.order_status (status_code);

ALTER TABLE omsdb.sales_order
ADD CONSTRAINT FK2sales_order FOREIGN KEY (channel_code) REFERENCES omsdb.sales_channel (channel_code);




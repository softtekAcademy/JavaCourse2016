DELIMITER //
CREATE PROCEDURE omsdb.delete_orders
(IN statuscode CHAR(20))
BEGIN
 DELETE FROM omsdb.sales_order WHERE status_code = statuscode;
END //
DELIMITER ;
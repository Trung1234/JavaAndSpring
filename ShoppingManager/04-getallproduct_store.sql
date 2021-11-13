CREATE  PROCEDURE `getAllProduct`(
	sortColumn INT,
    pageNo INT
)
BEGIN
	DECLARE pageSize,offsetVar INT  DEFAULT 8;
    set offsetVar = ( pageNo - 1) * pageSize;
	SELECT *
	FROM `product`
    order by (case sortColumn
              when 1 then id
              when 2 then name
              when 3 then brand
              when 4 then author_name
              when 5 then price
          end)
	LIMIT pageSize OFFSET offsetVar;
END
CREATE VIEW invoice_view AS
    SELECT i.*,c.fullname FROM invoice i JOIN client c ON c.id=i.id
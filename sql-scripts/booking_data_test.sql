SELECT
  b.id AS booking_number,
  c.first_name,
  c.last_name,
  b.number_of_persons,
  a1.name AS source_airport,
  a2.name AS destination_airport,
  f.departure_datetime AS flight_date,
  (b.number_of_persons * f.ticket_price) AS total_price
FROM
  booking b
JOIN
  customer c ON b.customer_id = c.id
JOIN
  flight f ON b.flight_id = f.id
JOIN
  airport a1 ON f.source = a1.id
JOIN
  airport a2 ON f.destination = a2.id
WHERE
  b.id = 1;

SELECT DISTINCT
  f.id,
  a1.name AS source_airport,
  a2.name AS destination_airport,
  al.name AS airline_name,
  f.departure_datetime
FROM
  flight f
JOIN
  airport a1 ON f.source = a1.id
JOIN
  airport a2 ON f.destination = a2.id
JOIN
  airline al ON f.airline = al.id
ORDER BY f.id;

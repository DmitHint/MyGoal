INSERT INTO public.coach (name, surname, rating)
VALUES ('Иван', 'Кузнецов', '4.5'),
       ('Виктория', 'Соколова', '4.8'),
       ('Никита', 'Смирнов', '4.9');


INSERT INTO public.training (coach_id, user_id, status, training_date_time)
VALUES (1, 1, 'finished', '2024-05-02T15:30:00'),
       (1, null, 'not started', '2024-05-18T15:30:00'),
       (1, null, 'not started', '2024-05-18T16:30:00'),
       (1, null, 'not started', '2024-05-18T17:30:00'),
       (1, null, 'not started', '2024-05-18T18:30:00'),
       (1, null, 'not started', '2024-05-18T19:30:00'),

       (2, null, 'not started', '2024-05-18T09:00:00'),
       (2, null, 'not started', '2024-05-18T10:00:00'),
       (2, null, 'not started', '2024-05-18T12:00:00'),
       (2, null, 'not started', '2024-05-18T14:00:00'),
       (2, null, 'not started', '2024-05-18T15:00:00'),

       (3, null, 'not started', '2024-05-18T14:00:00'),
       (3, null, 'not started', '2024-05-18T15:00:00'),
       (3, null, 'not started', '2024-05-18T17:00:00'),
       (3, null, 'not started', '2024-05-18T19:00:00'),
       (3, null, 'not started', '2024-05-18T20:00:00'),
-----------------------------------------1---------------------------
       (2, null, 'not started', '2024-05-19T15:30:00'),
       (2, null, 'not started', '2024-05-19T17:30:00'),
       (2, null, 'not started', '2024-05-19T18:30:00'),
       (2, null, 'not started', '2024-05-19T20:30:00'),

       (3, null, 'not started', '2024-05-19T09:00:00'),
       (3, null, 'not started', '2024-05-19T12:00:00'),
       (3, null, 'not started', '2024-05-19T15:00:00'),
       (3, null, 'not started', '2024-05-19T16:00:00'),

       (1, null, 'not started', '2024-05-19T12:00:00'),
       (1, null, 'not started', '2024-05-19T13:00:00'),
       (1, null, 'not started', '2024-05-19T14:00:00'),
       (1, null, 'not started', '2024-05-19T20:00:00'),
       (1, null, 'not started', '2024-05-19T21:00:00'),
---------------------------------------------------------------------

       (3, null, 'not started', '2024-05-20T16:30:00'),
       (3, null, 'not started', '2024-05-20T17:30:00'),
       (3, null, 'not started', '2024-05-20T18:30:00'),
       (3, null, 'not started', '2024-05-20T20:30:00'),

       (1, null, 'not started', '2024-05-20T09:00:00'),
       (1, null, 'not started', '2024-05-20T11:00:00'),
       (1, null, 'not started', '2024-05-20T15:00:00'),
       (1, null, 'not started', '2024-05-20T16:00:00'),

       (2, null, 'not started', '2024-05-20T14:00:00'),
       (2, null, 'not started', '2024-05-20T15:00:00'),
       (2, null, 'not started', '2024-05-20T19:00:00'),
       (2, null, 'not started', '2024-05-20T20:00:00'),
       (2, null, 'not started', '2024-05-20T18:00:00')
;
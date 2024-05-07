INSERT INTO public.coach (name, surname, rating)
VALUES ('Иван', 'Кузнецов', '4.5'),
       ('Виктория', 'Соколова', '4.8'),
       ('Никита', 'Смирнов', '4.9');


INSERT INTO public.training (coach_id, user_id, status, training_date_time)
VALUES (1, 1, 'finished', '2024-05-02T15:30:00'),
       (1, null, 'not started', '2024-05-08T15:30:00'),
       (1, null, 'not started', '2024-05-08T16:30:00'),
       (1, null, 'not started', '2024-05-08T17:30:00'),
       (1, null, 'not started', '2024-05-08T18:30:00'),
       (1, null, 'not started', '2024-05-08T19:30:00'),

       (2, null, 'not started', '2024-05-08T09:00:00'),
       (2, null, 'not started', '2024-05-08T10:00:00'),
       (2, null, 'not started', '2024-05-08T12:00:00'),
       (2, null, 'not started', '2024-05-08T13:00:00'),
       (2, null, 'not started', '2024-05-08T16:00:00'),

       (3, null, 'not started', '2024-05-08T14:00:00'),
       (3, null, 'not started', '2024-05-08T16:00:00'),
       (3, null, 'not started', '2024-05-08T17:00:00'),
       (3, null, 'not started', '2024-05-08T19:00:00'),
       (3, null, 'not started', '2024-05-08T18:00:00'),
---------------------------------------------------------------------
       (2, null, 'not started', '2024-05-09T15:30:00'),
       (2, null, 'not started', '2024-05-09T17:30:00'),
       (2, null, 'not started', '2024-05-09T18:30:00'),
       (2, null, 'not started', '2024-05-09T19:30:00'),

       (3, null, 'not started', '2024-05-09T09:00:00'),
       (3, null, 'not started', '2024-05-09T11:00:00'),
       (3, null, 'not started', '2024-05-09T12:00:00'),
       (3, null, 'not started', '2024-05-09T15:00:00'),
       (3, null, 'not started', '2024-05-09T16:00:00'),

       (1, null, 'not started', '2024-05-09T14:00:00'),
       (1, null, 'not started', '2024-05-09T15:00:00'),
       (1, null, 'not started', '2024-05-09T17:00:00'),
       (1, null, 'not started', '2024-05-09T20:00:00'),
       (1, null, 'not started', '2024-05-09T18:00:00'),
---------------------------------------------------------------------

       (3, null, 'not started', '2024-05-10T15:30:00'),
       (3, null, 'not started', '2024-05-10T17:30:00'),
       (3, null, 'not started', '2024-05-10T18:30:00'),
       (3, null, 'not started', '2024-05-10T19:30:00'),

       (1, null, 'not started', '2024-05-10T09:00:00'),
       (1, null, 'not started', '2024-05-10T11:00:00'),
       (1, null, 'not started', '2024-05-10T12:00:00'),
       (1, null, 'not started', '2024-05-10T15:00:00'),
       (1, null, 'not started', '2024-05-10T16:00:00'),

       (2, null, 'not started', '2024-05-10T14:00:00'),
       (2, null, 'not started', '2024-05-10T15:00:00'),
       (2, null, 'not started', '2024-05-10T19:00:00'),
       (2, null, 'not started', '2024-05-10T20:00:00'),
       (2, null, 'not started', '2024-05-10T18:00:00')
;
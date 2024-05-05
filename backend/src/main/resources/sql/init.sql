INSERT INTO public.coach (name, surname, rating)
VALUES ('Иван', 'Кузнецов', '4.5'),
       ('Виктория', 'Соколова', '4.8'),
       ('Никита', 'Смирнов', '4.9');


INSERT INTO public.training (coach_id, user_id, status, training_date_time)
VALUES (1, null, 'not started', '2024-05-05T14:00:00'),
       (3, 1, 'finished', '2024-04-25T14:00:00'),
       (2, 1, 'not started', '2024-05-01T15:00:00'),
       (1, null, 'not started', '2024-05-01T18:00:00'),
       (2, null, 'not started', '2024-05-01T19:00:00'),
       (3, null, 'not started', '2024-05-05T10:00:00'),
       (2, null, 'not started', '2024-05-05T13:00:00'),
       (2, null, 'not started', '2024-05-05T18:00:00'),
       (2, null, 'not started', '2024-05-05T19:00:00'),
       (2, null, 'not started', '2024-05-05T20:00:00'),
       (2, null, 'not started', '2024-05-05T09:00:00'),
       (2, null, 'not started', '2024-05-05T10:00:00'),
       (1, null, 'not started', '2024-05-05T08:00:00'),
       (1, null, 'not started', '2024-05-05T14:00:00'),
       (2, null, 'not started', '2024-05-07T09:00:00'),
       (2, null, 'not started', '2024-05-07T10:00:00'),
       (1, null, 'not started', '2024-05-07T08:00:00');
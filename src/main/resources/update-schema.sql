CREATE TABLE "emergencies" (
                               "id" integer PRIMARY KEY,
                               "fire_department_id" integer NOT NULL,
                               "fire_department_name" varchar NOT NULL,
                               "classification_id" integer NOT NULL,
                               "dangerous_level" integer NOT NULL CHECK (dangerous_level >= 0 AND dangerous_level <= 10),
                               "author_id" integer NOT NULL,
                               "date_time_created" timestamp NOT NULL,
                               "date_time_closed" timestamp,
                               "address_line_1" varchar NOT NULL,
                               "address_line_2" varchar,
                               "city" varchar NOT NULL,
                               "country" varchar NOT NULL,
                               "description" varchar,
                               "captain_id" integer,
                               "captain_full_name" varchar
);

CREATE TABLE "notified_user" (
                                 "emergency_id" integer,
                                 "user_id" integer,
                                 "user_full_name" varchar NOT NULL,
                                 "number_of_notifications" integer NOT NULL DEFAULT 1,
                                 "answer_id" integer NOT NULL DEFAULT 0,
                                 PRIMARY KEY(emergency_id, user_id)
);

CREATE TABLE "notified_department" (
                                       "emergency_id" integer,
                                       "department_id" integer,
                                       "department_name" varchar NOT NULL,
                                       "number_of_notifications" integer NOT NULL DEFAULT 1,
                                       "answer_id" integer NOT NULL DEFAULT 0,
                                       PRIMARY KEY(emergency_id, department_id)
);

CREATE TABLE "answer" (
                          "id" integer PRIMARY KEY,
                          "answer" varchar
);

CREATE TABLE "classification" (
                                  "id" integer PRIMARY KEY,
                                  "class" varchar,
                                  "class_description" varchar
);

ALTER TABLE notified_user ADD FOREIGN KEY ("emergency_id") REFERENCES emergency ("id");
ALTER TABLE notified_user ADD FOREIGN KEY ("answer_id") REFERENCES answer ("id");
ALTER TABLE notified_department ADD FOREIGN KEY ("emergency_id") REFERENCES emergency ("id");
ALTER TABLE notified_department ADD FOREIGN KEY ("answer_id") REFERENCES answer ("id");
ALTER TABLE emergency ADD FOREIGN KEY ("classification_id") REFERENCES "classification" ("id");
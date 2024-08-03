create table books
(
    id bigint generated always as identity,
    name varchar not null,
    year bigint not null,
    description varchar not null,
    genre varchar not null,

    constraint book_pk primary key (id)
);

create table authors
(
    id bigint generated always as identity,
    first_name varchar not null,
    last_name varchar not null,
    age bigint not null,
    nationality varchar not null,

    constraint authors_pk primary key (id)
);
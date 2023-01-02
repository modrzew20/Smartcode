create table account
(
    id         uuid         not null,
    version    bigint,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    role_name  varchar(255),
    primary key (id)
);
create table account_figures
(
    account_id uuid not null,
    figures_id uuid not null
);
create table role
(
    name varchar(255) not null,
    primary key (name)
);
create table shape
(
    dtype            varchar(31)  not null,
    id               uuid         not null,
    version          bigint,
    area             float(53)    not null,
    created_at       timestamp(6),
    created_by       varchar(255),
    last_modified_at timestamp(6),
    last_modified_by varchar(255),
    perimeter        float(53)    not null,
    type             varchar(255) not null,
    radius           float(53),
    length           float(53),
    width            float(53),
    side             float(53),
    primary key (id)
);
create table shape_modification
(
    id                  uuid         not null,
    changed_date        timestamp(6),
    parameter_name      varchar(255) not null,
    parameter_new_value float(53)    not null,
    parameter_old_value float(53)    not null,
    changed_by_id       uuid,
    primary key (id)
);
create table shape_modification_shapes
(
    shape_modification_id uuid not null,
    shapes_id             uuid not null
);
alter table if exists account add constraint UK_5vxwyorsr92jce3ore6h93k6q unique (login);
alter table if exists account_figures add constraint UK_8ke2mjavlvlomespi6lu3rrjo unique (figures_id);
alter table if exists account add constraint FKcintqxigc8q1dy18qm01d2qve foreign key (role_name) references role;
alter table if exists account_figures add constraint FK4187h4afae3hgn9o90cjoi504 foreign key (figures_id) references shape;
alter table if exists account_figures add constraint FKfkp2s7b945j3eph7of3k3uhe9 foreign key (account_id) references account;
alter table if exists shape_modification add constraint FK3j0htr3bvg5ew8tuu4og6hhpa foreign key (changed_by_id) references account;
alter table if exists shape_modification_shapes add constraint FKa4f0kgdu8lka3u42wm1m8say foreign key (shapes_id) references shape;
alter table if exists shape_modification_shapes add constraint FKc9i0oaobfenbxj7rfgbrl3q7d foreign key (shape_modification_id) references shape_modification;

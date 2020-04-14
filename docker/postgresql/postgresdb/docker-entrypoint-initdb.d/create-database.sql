create table projects
(
    name varchar not null,
    group_id varchar not null,
    artifact_id varchar not null,
    version varchar not null,
    has_sources boolean not null,

    jars_download_status int not null,
    jars_unpacking_status int not null,
    language_detection_status int not null,
    language_persistence_status int not null,
    metrics_calculation_status int not null,
    metrics_persistence_status int not null,
    pattern_detection_status int not null,
    pattern_persistence_status int not null,
    java_version_detection_status int not null,
    java_version_persistence_status int not null,
    java_version int,

    constraint projects_pkey
        primary key (name)
);

create table project_languages
(
    project varchar not null,
    name varchar not null,
    fraction float not null,
    constraint project_languages_pkey
        primary key (project, name),
    constraint project_languages_project_fkey
        foreign key (project) references projects on delete cascade
);

create table pakkages
(
    project varchar not null,
    name varchar not null,
    constraint pakkages_pkey
        primary key (name),
    constraint pakkages_project_fkey
        foreign key (project) references projects on delete cascade
);

create table clazzes
(
    pakkage varchar not null,
    name varchar not null,
    constraint clazzes_pkey
        primary key (name),
    constraint clazzes_pakkage_fkey
        foreign key (pakkage) references pakkages on delete cascade
);

create table clazz_metrics_ckjm
(
    clazz varchar not null,
    amc float not null,
    ca int not null,
    cam float not null,
    cbm int not null,
    cbo int not null,
    ce int not null,
    dam float not null,
    dit int not null,
    ic int not null,
    lcom int not null,
    lcom3 float not null,
    loc int not null,
    mfa float not null,
    moa int not null,
    noc int not null,
    nom int not null,
    nop int not null,
    npm int not null,
    rfc int not null,
    wmc int not null,
    constraint clazz_metrics_ckjm_pkey
        primary key (clazz),
    constraint clazz_metrics_ckjm_clazz_fkey
        foreign key (clazz) references clazzes on delete cascade
);

create table methods
(
    clazz varchar not null,
    name varchar not null,
    access_modifier varchar not null,
    constraint methods_pkey
        primary key (name),
    constraint methods_clazz_fkey
        foreign key (clazz) references clazzes on delete cascade
);

create table method_metrics_ckjm
(
    method varchar not null,
    cc int not null,
    constraint method_metrics_ckjm_pkey
        primary key (method),
    constraint method_metrics_ckjm_method_fkey
        foreign key (method) references methods on delete cascade
);

create table pattern_instances
(
    id uuid not null,
    project varchar not null,
    pattern varchar not null,
    constraint pattern_instances_pkey
        primary key (id),
    constraint pattern_instances_pattern
        foreign key (project) references projects on delete cascade
);

create table pattern_roles
(
    id uuid not null,
    instance_id uuid not null,
    role varchar not null,
    element varchar not null,
    constraint pattern_roles_pkey
        primary key (id),
    constraint pattern_roles_instance_id
        foreign key (instance_id) references pattern_instances on delete cascade
);

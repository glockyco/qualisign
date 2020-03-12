--------------------------------------------------------------------------------

-- usable projects overview
select *
from (
         select 0 as index, 'processed' as description, count(*) as count
         from projects
         where jars_download_status > 0
         union
         select 1 as index, 'correct version' as description, count(*) as count
         from projects
         where java_version <= 52
         union
         select 2 as index, 'correct language' as description, count(*) as count
         from projects
                  inner join project_languages on projects.name = project_languages.project
         where project_languages.name = 'Java'
         union
         select 3 as index, 'correct version + language' as description, count(*) as count
         from projects
                  inner join project_languages on projects.name = project_languages.project
         where projects.java_version <= 52
           and project_languages.name = 'Java'
         union
         select 9 as index, 'usable' as description, count(*) as count
         from projects
         where pattern_persistence_status = 1
     ) as results
order by index;

--------------------------------------------------------------------------------

-- programming language counts
select name, count(*)
from project_languages
group by name
order by count(*) desc;

-- single language project counts
select name, count(*)
from project_languages
where fraction = 1
group by name
order by count(*) desc;

-- Java version counts
select java_version, count(*)
from projects
group by java_version
order by java_version;

--------------------------------------------------------------------------------

-- processing status
select *
from (
         select 0                    as step_index,
                'download'           as step,
                jars_download_status as status,
                count(*)
         from projects
         group by jars_download_status
         union
         select 1                     as step_index,
                'unpacking'           as step,
                jars_unpacking_status as status,
                count(*)
         from projects
         group by jars_unpacking_status
         union
         select 2                             as step_index,
                'version_detection'           as step,
                java_version_detection_status as status,
                count(*)
         from projects
         group by java_version_detection_status
         union
         select 3                               as step_index,
                'version_persistence'           as step,
                java_version_persistence_status as status,
                count(*)
         from projects
         group by java_version_persistence_status
         union
         select 4                         as step_index,
                'language_detection'      as step,
                language_detection_status as status,
                count(*)
         from projects
         group by language_detection_status
         union
         select 5                           as step_index,
                'language_persistence'      as step,
                language_persistence_status as status,
                count(*)
         from projects
         group by language_persistence_status
         union
         select 6                          as step_index,
                'metrics_calculation'      as step,
                metrics_calculation_status as status,
                count(*)
         from projects
         group by metrics_calculation_status
         union
         select 7                          as step_index,
                'metrics_persistence'      as step,
                metrics_persistence_status as status,
                count(*)
         from projects
         group by metrics_persistence_status
         union
         select 8                        as step_index,
                'pattern_detection'      as step,
                pattern_detection_status as status,
                count(*)
         from projects
         group by pattern_detection_status
         union
         select 9                          as step_index,
                'pattern_persistence'      as step,
                pattern_persistence_status as status,
                count(*)
         from projects
         group by pattern_persistence_status
     ) as results
where status > 0
order by step_index, status;

--------------------------------------------------------------------------------

-- projects with failed processing steps
select *
from projects
where jars_download_status > 1
   or jars_unpacking_status > 1
   or java_version_detection_status > 1
   or java_version_persistence_status > 1
   or language_detection_status > 1
   or language_persistence_status > 1
   or metrics_calculation_status > 1
   or metrics_persistence_status > 1
   or pattern_detection_status > 1
   or pattern_persistence_status > 1;

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------

-- projects, packages, classes, methods
select *
from (
         select 0 as index, 'projects' as item, count(*) as count
         from projects
         union
         select 1 as index, 'packages' as item, count(*) as count
         from pakkages
         union
         select 2 as index, 'classes' as item, count(*) as count
         from clazzes
         union
         select 3 as index, 'methods' as item, count(*) as count
         from methods
     ) as results
order by index;

--------------------------------------------------------------------------------

-- patterns
select (row_number() over (order by count desc) - 1) as index, *
from (
         select 'Total' as pattern, count(*) as count
         from pattern_instances
         union
         select pattern, count(*) as count
         from pattern_instances
         group by pattern
     ) as results
order by count desc;

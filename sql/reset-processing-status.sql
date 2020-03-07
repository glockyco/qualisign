update projects
set
    jars_download_status = 0,
    jars_unpacking_status = 0,
    language_detection_status = 0,
    language_persistence_status = 0,
    metrics_calculation_status = 0,
    metrics_persistence_status = 0,
    pattern_detection_status = 0,
    pattern_persistence_status = 0,
    java_version_detection_status = 0
where
    jars_download_status != 0
    OR jars_unpacking_status != 0
    OR language_detection_status != 0
    OR language_persistence_status != 0
    OR metrics_calculation_status != 0
    OR metrics_persistence_status != 0
    OR pattern_detection_status != 0
    OR pattern_persistence_status != 0
    OR java_version_detection_status != 0
;

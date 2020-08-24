select 'private ' || 
        decode(lower(data_type), ' number ', ' int ', ' String ') || 
        lower(column_name) ||';'
from cols
where lower(table_name) = 'lprod';


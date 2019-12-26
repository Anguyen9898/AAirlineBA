SELECT * FROM aabairline.airport_info WHERE (A_ID not like "BMV" and  A_ID  not like "VCA" and  A_ID not like "VCL" and  A_ID not like "DLI" and  A_ID not like "DAD" 
and  A_ID not like "TPE" and  A_ID not like "VDH" and  A_ID not like "HAN" and  A_ID not like "HPH"and  A_ID not like "SGN" and  A_ID not like "HUI" and  A_ID not like "CXR" 
and  A_ID not like "PQC" and  A_ID not like "PXU" and  A_ID not like "UIH") ;
DELETE FROM aabairline.airport_info WHERE A_ID like "CAH" OR A_ID like "DIN" OR A_ID like "TBB" OR A_ID like "VCS" OR A_ID like "VKG";
SELECT * FROM aabairline.airport_info;
SELECT count(*) FROM aabairline.airport_info;

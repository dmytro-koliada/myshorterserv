insert into k_pacs (titles, descriptions, creationDate) values("title 1", "description 1", "29-06-2022");
insert into k_pacs (titles, descriptions, creationDate) values("title 2", "description 2", "29-06-2022");
insert into k_pacs (titles, descriptions, creationDate) values("title 3", "description 3", "29-06-2022");

insert into k_pac_sets (titles) values("title 1");
insert into k_pac_sets (titles) values("title 2");
insert into k_pac_sets (titles) values("title 3");

insert into k_pac_k_pac_sets (k_pac_id, k_pac_set_id) values(1, 1);
insert into k_pac_k_pac_sets (k_pac_id, k_pac_set_id) values(2, 1);
insert into k_pac_k_pac_sets (k_pac_id, k_pac_set_id) values(3, 2);
insert into k_pac_k_pac_sets (k_pac_id, k_pac_set_id) values(1, 3);
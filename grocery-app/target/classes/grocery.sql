INSERT INTO item_type (id, name) VALUES (1, "food");
INSERT INTO item_type (id, name) VALUES (2, "clothing");
INSERT INTO item_type (id, name) VALUES (3, "electronics");
INSERT INTO item_type (id, name) VALUES (4, "sundries");
INSERT INTO item_type (id, name) VALUES (5, "miscellaneous");

INSERT INTO grocery_items (id, name, type) VALUES (item_seq.NEXTVAL, 'water', '1');
INSERT INTO grocery_items (id, name, type) VALUES (item_seq.NEXTVAL, 't-shirt', '2');
INSERT INTO grocery_items (id, name, type) VALUES (item_seq.NEXTVAL, 'batteries', '3');
INSERT INTO grocery_items (id, name, type) VALUES (item_seq.NEXTVAL, 'drying sheets', '4');

INSERT INTO grocery_list (id, name, item) VALUES (item_seq.NEXTVAL, 'my list', 2);

COMMIT;
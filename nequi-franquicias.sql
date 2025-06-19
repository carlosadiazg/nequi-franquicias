drop table if exists branches_products;

drop table if exists products;

drop table if exists branches;

drop table if exists franchises;

-- TABLE FRANCHISES
create table franchises(
	id SERIAL,
	name VARCHAR(255)
);

alter table franchises add primary key (id);

alter table franchises 
  add constraint uk_franchises_name
  unique (name);

-- TABLE BRANCHES
create table branches(
	id SERIAL,
	name VARCHAR(255),
	id_franchise integer
);

alter table branches add primary key (id);

alter table branches
add constraint fk_franchises
foreign key (id_franchise)
references franchises (id);

alter table branches
  add constraint uk_branches_name
  unique (name,
id_franchise);

-- TABLE PRODUCTS
create table products(
	id SERIAL,
	name VARCHAR(255),
	stock numeric,
	id_branch integer
);

alter table products add primary key (id);

alter table products
add constraint fk_branches
foreign key (id_branch)
references branches (id);

alter table products 
  add constraint uk_products_name
  unique (name,
id_branch);

CREATE TABLE recipe
(
  id serial PRIMARY KEY,
  name VARCHAR (255),
  slug VARCHAR (255) NOT NULL UNIQUE,
  instructions VARCHAR (255),
  difficulty INTEGER,
  prep_time INTEGER,
  created_at timestamptz NOT NULL DEFAULT now(),
  updated_at timestamptz NOT NULL DEFAULT now()
);

CREATE TABLE ingredient
(
  id serial PRIMARY KEY,
  name VARCHAR (255),
  slug VARCHAR (255) NOT NULL
);

CREATE TABLE recipe_ingredients
(
  recipe_id int REFERENCES recipe (id) ON UPDATE CASCADE ON DELETE CASCADE,
  ingredient_id int REFERENCES ingredient (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT recipe_ingredient_pkey PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE tag
(
  id serial PRIMARY KEY,
  name VARCHAR (255),
  slug VARCHAR (255) NOT NULL UNIQUE
);

CREATE TABLE recipe_tags
(
  recipe_id int REFERENCES recipe (id) ON UPDATE CASCADE ON DELETE CASCADE,
  tag_id int REFERENCES tag (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT recipe_tag_pkey PRIMARY KEY (recipe_id, tag_id)
);

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
  slug VARCHAR (255) NOT NULL,
  created_at timestamptz NOT NULL DEFAULT now(),
  updated_at timestamptz NOT NULL DEFAULT now()
);

CREATE TABLE recipe_ingredients
(
  recipe_id int REFERENCES recipe (id) ON UPDATE CASCADE ON DELETE CASCADE,
  ingredient_id int REFERENCES ingredient (id) ON UPDATE CASCADE ON DELETE CASCADE,
  created_at timestamptz NOT NULL DEFAULT now(),
  updated_at timestamptz NOT NULL DEFAULT now(),
  CONSTRAINT recipe_ingredient_pkey PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE tag
(
  id serial PRIMARY KEY,
  name VARCHAR (255),
  slug VARCHAR (255) NOT NULL UNIQUE,
  created_at timestamptz NOT NULL DEFAULT now(),
  updated_at timestamptz NOT NULL DEFAULT now()
);

CREATE TABLE recipe_tags
(
  recipe_id int REFERENCES recipe (id) ON UPDATE CASCADE ON DELETE CASCADE,
  tag_id int REFERENCES tag (id) ON UPDATE CASCADE ON DELETE CASCADE,
  created_at timestamptz NOT NULL DEFAULT now(),
  updated_at timestamptz NOT NULL DEFAULT now(),
  CONSTRAINT recipe_tag_pkey PRIMARY KEY (recipe_id, tag_id)
);

CREATE OR REPLACE FUNCTION update_updated_at()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = now();
  RETURN NEW;
END
$$ language 'plpgsql';

CREATE TRIGGER update_recipe_updated_at BEFORE UPDATE
  ON recipe FOR EACH ROW EXECUTE PROCEDURE
  update_updated_at();

CREATE TRIGGER update_ingredient_updated_at BEFORE UPDATE
  ON ingredient FOR EACH ROW EXECUTE PROCEDURE
  update_updated_at();

CREATE TRIGGER update_tag_updated_at BEFORE UPDATE
  ON tag FOR EACH ROW EXECUTE PROCEDURE
  update_updated_at();

CREATE TRIGGER update_recipe_ingredients_updated_at BEFORE UPDATE
  ON recipe_ingredients FOR EACH ROW EXECUTE PROCEDURE
  update_updated_at();

CREATE TRIGGER update_recipe_tags_updated_at BEFORE UPDATE
  ON recipe_tags FOR EACH ROW EXECUTE PROCEDURE
  update_updated_at();

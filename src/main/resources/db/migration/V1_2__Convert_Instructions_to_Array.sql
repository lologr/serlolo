DROP TRIGGER update_instruction_updated_at ON instruction;
DROP TRIGGER update_recipe_instructions_updated_at ON recipe_instruction;

DROP TABLE recipe_instruction;
DROP TABLE instruction;

ALTER TABLE recipe DROP COLUMN instructions;
ALTER TABLE recipe ADD COLUMN instructions VARCHAR(255)[] DEFAULT '{}';

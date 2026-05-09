-- Ajout de la colonne indiquant si le personnage est sélectionnable en jeu
-- exclut les personnages techniques
ALTER TABLE players
    ADD COLUMN playable BOOLEAN NOT NULL DEFAULT false;

-- Ajout de la colonne indiquant si le personnage est une version tainted
ALTER TABLE players
    ADD COLUMN tainted BOOLEAN NOT NULL DEFAULT false;

-- Commentaires sur les colonnes
COMMENT ON COLUMN players.playable IS 'Indique si le personnage est sélectionnable dans le menu de sélection du jeu';
COMMENT ON COLUMN players.tainted IS 'Indique si le personnage est une version tainted';
CREATE TABLE IF NOT EXISTS ` character_quests `
(
    `
    char_id
    `
    INT
    NOT
    NULL
    DEFAULT
    '0',
    `
    name
    `
    VARCHAR
(
    40
) CHARACTER SET UTF8 NOT NULL DEFAULT '',
    ` var ` VARCHAR
(
    127
) CHARACTER SET UTF8 NOT NULL DEFAULT '',
    ` value ` VARCHAR
(
    255
) CHARACTER SET UTF8,
    PRIMARY KEY
(
    `
    char_id
    `,
    `
    name
    `,
    `
    var
    `
)
    ) ENGINE=MyISAM;
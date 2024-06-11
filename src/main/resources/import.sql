-- Drop the existing music table and sequence
DROP TABLE IF EXISTS music CASCADE;
DROP SEQUENCE IF EXISTS music_id_seq;

-- Create the sequence
CREATE SEQUENCE music_id_seq START WITH 1 INCREMENT BY 1;

-- Create the music table
CREATE TABLE music (
                       id BIGINT PRIMARY KEY DEFAULT nextval('music_id_seq'),
                       name VARCHAR(255),
                       artist VARCHAR(255)
);

-- Drop the existing users, playlist, and playlist_music tables if they exist
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS playlist CASCADE;
DROP TABLE IF EXISTS playlist_music CASCADE;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL
    );

-- Create playlist table
CREATE TABLE IF NOT EXISTS playlist (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

-- Create playlist_music table
CREATE TABLE IF NOT EXISTS playlist_music (
                                              playlist_id INTEGER NOT NULL,
                                              music_id INTEGER NOT NULL,
                                              PRIMARY KEY (playlist_id, music_id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(id),
    FOREIGN KEY (music_id) REFERENCES music(id)
    );

-- Insert data into users table
INSERT INTO users (id, name, age)
VALUES
    (1, 'User1', 10),
    (2, 'User2', 20),
    (3, 'User3', 30),
    (4, 'User4', 40)
    ON CONFLICT (id) DO NOTHING;

-- Insert data into music table
INSERT INTO music (id, name, artist)
VALUES
    (1, 'Shape of You', 'Ed Sheeran'),
    (2, 'Blinding Lights', 'The Weeknd'),
    (3, 'Rolling in the Deep', 'Adele'),
    (4, 'Havana', 'Camila Cabello'),
    (5, 'Uptown Funk', 'Mark Ronson ft. Bruno Mars')
    ON CONFLICT (id) DO NOTHING;

-- Insert data into playlist table
INSERT INTO playlist (id, name, user_id)
VALUES
    (1, 'My First Playlist', 1),
    (2, 'My Second Playlist', 3),
    (3, 'My Third Playlist', 2),
    (4, 'My Fourth Playlist', 1),
    (5, 'My Fifth Playlist', 2)
    ON CONFLICT (id) DO NOTHING;

-- Insert data into playlist_music table
INSERT INTO playlist_music (playlist_id, music_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 5),
    (2, 2),
    (2, 1),
    (3, 4),
    (3, 5),
    (4, 2),
    (4, 3),
    (4, 5),
    (5, 1),
    (5, 5)
    ON CONFLICT DO NOTHING;

(ns myapp.models.migration
  (:require [clojure.java.jdbc :as sql]
            [myapp.models.tasks :as task]))


(defn migrated? []
  (pos?(:count (first (sql/query task/spec
                 [(str "SELECT count(*) as count FROM sqlite_master WHERE type='table' AND name='tasks';")])))))


(defn migrate []
  (when (not (migrated?))
    (print "Creating database structure...") (flush)
    (sql/db-do-commands task/spec
                        (sql/create-table-ddl
                         :tasks
                         [[:id :int :primary :key :autoincrement]
                         [:name :varchar "NOT NULL"]
                         [:description :varchar]
                         [:links :varchar]
                         [:completion :integer "NOT NULL" "DEFAULT 0"]
                         [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]
                         [:updated_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]]))
    (println " done.")))

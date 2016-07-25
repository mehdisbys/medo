(ns myapp.models.tasks
  (:require [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "sqlite:/Users/mehdi.souihed/projects/clojure/medo/src/myapp/db/db.sqlite"))

(defn all []
  (into [] (sql/query spec ["select * from tasks order by id desc"])))

(defn new-task [name desc links]
  (sql/insert! spec :tasks {:name name :description desc :links links}))

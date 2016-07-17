(ns myapp.routes
  (:require [compojure.core :refer :all]))


(defroutes endpoints
  (GET "/" [] "Hello World")
  (GET "/posts" req
       #(let [title (get (:params %) :title)
               author (get (:params %) :author)]
           (str "The title is " title " and the author is " author))))

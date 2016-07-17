(ns myapp.core
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.reload :refer :all]
            [ring.adapter.jetty :as jetty]
            [org.httpkit.server :refer [run-server]]
            [myapp.routes :as my-routes]
            [myapp.views.layout :as layout]))


(defroutes endpoints
  my-routes/endpoints
  (route/not-found (layout/four-oh-four)))


(defn app
  []
  (-> endpoints
    (wrap-reload '(myapp.core myapp.views.layout))
    (wrap-defaults site-defaults)))

(defn start-server
  []
  (jetty/run-jetty (app) {:port 5000 :join? false}))

(defn -main [& args]
  (start-server))

(defproject myapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :main myapp.core
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.1.8"]
                 [http-kit "2.1.16"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-devel "1.6.0-beta4"]
                 [ring/ring-defaults "0.1.1"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.6.2-alpha2"]
                 [org.xerial/sqlite-jdbc "3.8.11.2"]])

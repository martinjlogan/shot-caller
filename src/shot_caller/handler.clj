(ns shot-caller.handler
  (:require [shot-caller.controller :as controller]
            [compojure.core :as cc]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defn init []
  (println "Shot Caller is starting"))

(cc/defroutes app-routes
  (cc/GET "/"
       []
       controller/home-page)
  (cc/POST "/leads"
       ;;{params :params}
       ;;{{name :name} :params}
       []
       controller/leads-new)
  (cc/POST "/leads/claim" 
       []
       controller/leads-claim)
  (cc/GET "/leads/:lead-code" 
       []
       controller/leads-show)

;; not RESTful stuff below
  (cc/GET "/enter-lead-code" 
       []
       controller/leads-enter-lead-code)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

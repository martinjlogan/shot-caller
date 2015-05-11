(ns shot-caller.views
  (:require [clojure.string :as str]
            [hiccup.page :as hic-p]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Shot Caller: " title)]
   (hic-p/include-css "/css/styles.css")])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/lead"} "Show a Lead"]
   " ]"])

(defn home-page
  []
  (hic-p/html5
   (gen-page-head "Home")
   header-links
   [:h1 "Home"]
   [:p "Shot Caller lead servicing"]))

(defn leads-show
  [lead-code loan-number]
    (hic-p/html5
     (gen-page-head "Show Lead")
     header-links
     [:h1 "Lead Info"]
     [:p "Lead Code: " lead-code]
     [:p "Loan Number: " loan-number]))

(defn leads-enter-lead-code
  []
  (hic-p/html5
   (gen-page-head "Home")
   header-links
   [:h1 "Enter Lead Code"]
   [:form {:action "/leads/claim" :method "POST"}
    [:p [:input {:type "text" :lead-code "lead-code"}]]
    [:p [:input {:type "submit" :value "submit location"}]]]))

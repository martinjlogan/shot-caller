(ns shot-caller.controller
  (:require [shot-caller.db :as db]
            [shot-caller.views :as views]))

(defn home-page [request]
  (views/home-page))

(defn leads-new 
  "add a new lead into the system"
  [request]
  (let [loan-number (get-in request [:params :loan-number])
        lead-code   (str (java.util.UUID/randomUUID))]
    (println "lead code *******" loan-number)
    (db/add-lead loan-number lead-code)
    (views/leads-show lead-code loan-number)))
    
(defn leads-show
  "show a lead when given its lead code"
  [request]
  (let [lead-code   (get-in request [:params :lead-code])
        {loan-number :loan_number} (db/get-loan-number-by-lead-code lead-code)]
    (views/leads-show lead-code loan-number)))

(defn leads-claim
  "mark a lead as claimed"
  [request]
  (let lead-code (get-in request [:params :lead-code])
    XXX write a function to mark the lead as claimed then send back the results to show lead. Show lead probably needs functionality to process a whole lead and switch on output based on whether the lead is claimed or not

(defn leads-enter-lead-code
  "have the user enter a lead code to get a lead"
  [request]
   (views/leads-enter-lead-code))

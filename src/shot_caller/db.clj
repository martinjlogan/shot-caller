(ns shot-caller.db
  (:require [clojure.java.jdbc :as sql]))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2:file"
              :subname "db/shot-caller"})

(defn add-lead
  [loan-number lead-code]
  (let [results (sql/with-connection db-spec
                  (sql/insert-record :leads
                                     {:loan_number loan-number :lead_code lead-code :online_try false 
                                      :retail_try false :claimed false}))]
    (assert (= (count results) 1))
    (first (vals results))))

(defn get-loan-by-lead-code
  [lead-code]
  (let [results (sql/with-connection db-spec
                  (sql/with-query-results res
                    ["select * from leads where lead_code = ?" lead-code]
                    (doall res)))]
    (assert (= (count results) 1))
    (first results)))

(defn get-loan-number-by-lead-code
  [lead-code]
  (let [results (sql/with-connection db-spec
                  (sql/with-query-results res
                    ["select loan_number from leads where lead_code = ?" lead-code]
                    (doall res)))]
    (assert (= (count results) 1))
    (first results)))


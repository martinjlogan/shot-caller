(require '[clojure.java.jdbc :as sql])
(sql/with-connection
  {:classname "org.h2.Driver"
   :subprotocol "h2:file"
   :subname "db/shot-caller"}

  (sql/create-table :leads
    [:id "bigint primary key auto_increment"]
    [:loan_number "integer"]
    [:lead_code "varchar(40)"]
    [:online_try "bool"]
    [:retail_try "bool"]
    [:answered "bool"])


  (sql/insert-records :leads
    {:loan_number 0 :lead_code "unique-lead-code" :online_try false :retail_try false :claimed false}))

# HealthCareSystem

HealthCareSystem, temel sağlık hizmetleri yönetimini simüle eden, Java tabanlı, konsol uygulaması olarak tasarlanmış bir projedir. Bu sistem; hastalar, doktorlar ve randevular gibi temel bileşenlerin yönetimini sağlar ve dosya tabanlı veri saklama kullanır.

## 📌 Amaç

Bu proje, nesne yönelimli programlama prensiplerini uygulamak, gerçek dünya problemlerini yazılım mimarisiyle modellemek ve dosya tabanlı veri yönetimini öğretmek amacıyla geliştirilmiştir.

---

## ⚙️ Özellikler

- ✅ Doktor kaydı ekleme, silme, listeleme
- ✅ Hasta kaydı ekleme, silme, listeleme
- ✅ Randevu oluşturma, iptal etme ve geçmiş randevuları görüntüleme
- ✅ Verilerin dosya sistemi üzerinden kalıcı olarak saklanması (Serialization)
- ✅ Konsol üzerinden kullanıcı ile etkileşim

---

## 🛠️ Kullanılan Teknolojiler

- Java 17+
- OOP (Nesne Yönelimli Programlama)
- File I/O & Object Serialization
- Temel Katmanlı Mimari

---

## 📁 Proje Yapısı

```
HealthCareSystem/
├── data/                   # Veritabanı yerine kullanılan veri yönetimi sınıfları
│   └── DataManager.java
│
├── entities/               # Temel varlık sınıfları
│   ├── Doctor.java
│   ├── Patient.java
│   └── Appointment.java
│
├── services/               # İş kurallarını içeren servis sınıfları
│   ├── DoctorService.java
│   ├── PatientService.java
│   └── AppointmentService.java
│
├── Main.java               # Uygulamanın giriş noktası
└── README.md               # Proje açıklaması
```

---

## 🚀 Kurulum

1. Projeyi indir:
```
https://github.com/Bashmaistro/HealthCareSystem/archive/refs/heads/master.zip
```
veya terminal üzerinden:

```bash
git clone https://github.com/Bashmaistro/HealthCareSystem.git
```

2. Java destekli bir IDE ile (IntelliJ IDEA, Eclipse vb.) projeyi aç.

3. `Main.java` dosyasını çalıştırarak uygulamayı başlat.

---

## 💡 Kullanım Senaryoları

- Yeni bir hasta eklemek için `PatientService.addPatient(...)` metodu kullanılabilir.
- Randevu almak için `AppointmentService.scheduleAppointment(...)` çağrılır.
- Program kapatıldığında tüm veriler `data/` klasöründeki dosyalara otomatik olarak yazılır.

---

## 🔐 Veri Saklama

Veriler Java'nın `ObjectOutputStream` ve `ObjectInputStream` sınıflarıyla `.ser` dosyalarına yazılır ve oradan okunur. Bu sayede, uygulama kapandığında bilgiler kaybolmaz.

---

## 👤 Geliştirici

**Emirhan Yıldız**  
GitHub: [@Bashmaistro](https://github.com/Bashmaistro)  
LinkedIn: [linkedin.com/in/emirhanyildz](https://linkedin.com/in/emirhanyildz)

---

## 📄 Lisans

Bu proje MIT lisansı ile lisanslanmıştır. Daha fazla bilgi için `LICENSE` dosyasına göz atabilirsiniz.


- 1.2 Analiza el manifest
- ¿Cuál es el nombre completo (`android:name`) de la Activity principal?
andorid: name, si hablamos de cuál es el name de la actividad principal
entonces seria .MainActivity en forma corta pero el completo es
co.edu.ucaldas.ciclodevidademo.MainActivity


- ¿Qué `intent-filter` la marca como pantalla de inicio?
intent - filter: filtro de intensiones que declara capacidades( acciones
que puede realizar el componente)
  * <action android:name="android.intent.action.MAIN" />. Asi es cuando se 
combina la categoria 
  * <category android:name="android.intent.category.LAUNCHER" />
  
    
- ¿Qué pasaría si dos Activities declararan el mismo `intent-filter` de `LAUNCHER`?
lo que puede pasar es que la pantalla de inicio se crearian dos iconos independientes 
para la misma aplicacion, a demas ambos iconos funcionarian de abriria la actividad asignada.

-1.3 Analisa los SDK
- ¿Qué diferencia real hay entre los tres (minSdk, compileSdk, targetSdk)?
* minSdk: es la version minima del sistema operativo que exige la app.
de esta forma el sistema peude estar seguro que el telefono tiene  lo 
minimo para funcionar.
* compileSdk: es la version de las APIs del SDK y sirve para que el compilador 
analice el codigo en tiempo real, hablando del codigo kotlin.
* targetSdk: es la version dende el desarrollador prueba la aplicacion y 
puede garantizar compatibilidad.

- ¿Qué consecuencia tiene subir el `targetSdk` sin probar la app? (pista: `android:exported` 
en Android 12+)


Consecuencia de subir el targetSdk sin probar:
Si subes el targetSdk no te daras cuenta que Android tiene nuevas reglas obligatorias,
por esta razon cuando compiles la app se rompera o dara error.

-1.4 `applicationId` vs `package`
-diferencia entre el `applicationId` (Gradle) y el nombre del paquete Kotlin
(`package` en el código).
*aplicationId (Gradle): es el que se encarga de definir la identidad unica
de la app publicada en la play store y en el sistema operativo en android.

*package (kotlin): es el espacio de nombres en el sistema android, es decir es 
el identificador que organiza el codigo interno, es util en adroid studio
para identificar las clases creadas automaticamente en cada proyecto. evita confusiines 
asi se repetian los nombres ya que cada paquete tiene un nombre unico.






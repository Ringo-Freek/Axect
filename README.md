[![](https://jitpack.io/v/Ringo-Freek/Axect.svg)](https://jitpack.io/#Ringo-Freek/Axect)

### Подключение

    allprojects {
	    repositories {
			maven { url 'https://jitpack.io' }
		}
	}
    
    dependencies {
        implementation 'com.github.Ringo-Freek:Axect:axect-lib:X.X.X'
	}

### Объявление

    AxectBuilder builder = new AxectBuilder();
    Axect axect = new Axect(builder);

AxectBuilder позволяет управлять параметрами параллакса, такими как:
* setParallaxHeight(float value); Высота View, для которой создается эффект параллакса
* setZoom(boolean value); Параметр отвечает за характер параметров scaleX и scaleY. При значении true View величивается, а при зачении false - уменьшается. По умолчанию имеет значение false.
* setScaleX(boolean value); Значение true позволяет изменять у View значение scaleX. По умолчанию имеет значение false.
* setScaleY(boolean value); Значение true позволяет изменять у View значение scaleY. По умолчанию имеет значение false.

Необходимо передать в Axect контент с прокруткой, в котором находится View с эффектом параллакса.

Для RecyclerView

    setContent(RecyclerView content);

Для NestedScrollView

    setContent(NestedScrollView content, View view)

Второй параметр метода View с эффектом параллакса.

Интерфейс AxectView необходимо реализовать у ViewHolder. В методе

    View getView();

вернуть View (! не itemView), для которой создается эффект параллакса.
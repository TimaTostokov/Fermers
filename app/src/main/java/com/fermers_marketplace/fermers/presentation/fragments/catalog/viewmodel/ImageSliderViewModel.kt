package com.fermers_marketplace.fermers.presentation.fragments.catalog.viewmodel

import androidx.lifecycle.ViewModel
import com.fermers_marketplace.fermers.domain.usecase.ImageSliderUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ImageSliderViewModel(private val useCase: ImageSliderUseCase) : ViewModel() {

    private val _currentItem = MutableStateFlow(0)
    val currentItem: StateFlow<Int> get() = _currentItem

    private val _canMoveNext = MutableStateFlow(true)
    val canMoveNext: StateFlow<Boolean> get() = _canMoveNext

    private val _canMovePrevious = MutableStateFlow(false)
    val canMovePrevious: StateFlow<Boolean> get() = _canMovePrevious

    val images: List<Int> = useCase.getImages()

    fun moveNext() {
        _currentItem.value.let {
            if (useCase.canMoveNext(it)) {
                _currentItem.value = it + 1
                updateButtonVisibility()
            }
        }
    }

    fun movePrevious() {
        _currentItem.value.let {
            if (useCase.canMovePrevious(it)) {
                _currentItem.value = it - 1
                updateButtonVisibility()
            }
        }
    }

    fun setCurrentItem(position: Int) {
        _currentItem.value = position
        updateButtonVisibility()
    }

    private fun updateButtonVisibility() {
        _currentItem.value.let {
            _canMoveNext.value = useCase.canMoveNext(it)
            _canMovePrevious.value = useCase.canMovePrevious(it)
        }
    }

}



//class MediaAdapter(private val items: List<PlayerItem>) :
//    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    companion object {
//        private const val TYPE_VIDEO = 0
//        private const val TYPE_IMAGE = 1
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (items[position]) {
//            is PlayerItem.Video -> TYPE_VIDEO
//            is PlayerItem.Image -> TYPE_IMAGE
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (viewType == TYPE_VIDEO) {
//            val binding =
//                ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            VideoViewHolder(binding)
//        } else {
//            val binding =
//                ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            ImageViewHolder(binding)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder) {
//            is VideoViewHolder -> holder.bind(items[position] as PlayerItem.Video)
//            is ImageViewHolder -> holder.bind((items[position] as PlayerItem.Image).imageUrl)
//        }
//    }
//
//    override fun getItemCount() = items.size
//
//    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        private var exoPlayer: ExoPlayer? = null
//
//        @OptIn(UnstableApi::class)
//        fun bind(mediaItem: PlayerItem.Video) {
//            Log.d("VideoViewHoldr", "Initializing ExoPlayer for URL: ${mediaItem.videoUrl}")
//            exoPlayer = ExoPlayerUtil.initializePlayer(binding.root.context, mediaItem.videoUrl)
//            val hlsMediaSource =
//                HlsMediaSource.Factory(DefaultHttpDataSource.Factory()).createMediaSource(
//                    MediaItem.fromUri(mediaItem.videoUrl)
//                )
//            exoPlayer?.setMediaSource(hlsMediaSource)
//            binding.videoView.player = exoPlayer
//        }
//
//        fun releasePlayer() {
//            ExoPlayerUtil.releasePlayer(exoPlayer)
//            exoPlayer = null
//        }
//    }
//
//    inner class ImageViewHolder(private val binding: ItemImageBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(url: String) {
//            Glide.with(binding.root.context).load(url).into(binding.imageView)
//            ZoomHelper.addZoomableView(binding.imageView)
//        }
//    }
//
//    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
//        super.onViewRecycled(holder)
//        if (holder is VideoViewHolder) {
//            holder.releasePlayer()
//        }
//    }
//
//}

//sealed class PlayerItem(private val url: String) {
//    data class Video(val videoUrl: String) : PlayerItem(videoUrl)
//    data class Image(val imageUrl: String) : PlayerItem(imageUrl)
//}

////    /* @OptIn(UnstableApi::class)
////         fun initializePlayer(context: Context, mediaUrl: String): ExoPlayer {
////
////             val dataSourceFactory = DefaultHttpDataSource.Factory()
////
////
////             val mediaSource: MediaSource = when {
////                 mediaUrl.endsWith(".m3u8") -> {
////                     // HLS источник для потоков HLS.
////                     HlsMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(mediaUrl))
////                 }
////                 mediaUrl.endsWith(".mp4") -> {
////                     // ProgressiveMediaSource для MP4.
////                     ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(mediaUrl))
////                 }
////                 else -> {
////
////                     Log.e("ExoPlayerUtil", "Unsupported media format: ${mediaUrl}")
////                     return ExoPlayer.Builder(context).build()
////                 }
////             }
////
////             return ExoPlayer.Builder(context).build().apply {
////                 Log.d("ExoPlayerUtil", "URL: $mediaUrl")
////
////                 setMediaSource(mediaSource)
////                 trackSelectionParameters = trackSelectionParameters
////                     .buildUpon()
////                     .setMaxVideoSizeSd()
////                     .build()
////                 playWhenReady = true
////                 prepare()*/

//import android.content.Context
//import android.util.Log
//import androidx.media3.common.MediaItem
//import androidx.media3.common.MimeTypes
//import androidx.media3.common.PlaybackException
//import androidx.media3.common.Player
//import androidx.media3.exoplayer.ExoPlayer
//
//object ExoPlayerUtil {
//    fun initializePlayer(context: Context, mediaUrl: String): ExoPlayer {
//
//
//
//        return ExoPlayer.Builder(context).build().apply {
//            Log.d("shamal", mediaUrl)
//            val mediaItemBuilder = MediaItem.Builder().setUri(mediaUrl)
//
//            val mimeType = when {
//                mediaUrl.endsWith(".mpd") -> MimeTypes.APPLICATION_MPD
//                mediaUrl.endsWith(".mp4") -> MimeTypes.VIDEO_MP4
//                else -> "NULL"
//            }
//            mediaItemBuilder.setMimeType(mimeType)
//
//            val mediaItem = mediaItemBuilder.build()
//
//            setMediaItem(mediaItem)
//            trackSelectionParameters = trackSelectionParameters
//                .buildUpon()
//                .setMaxVideoSizeSd()
//                .build()
//            playWhenReady = true
//            prepare()
//
//            addListener(object : Player.Listener {
//                override fun onPlaybackStateChanged(playbackState: Int) {
//                    when (playbackState) {
//                        Player.STATE_BUFFERING -> Log.d("ExoPlayer", "Буферизация...")
//                        Player.STATE_READY -> Log.d("ExoPlayer", "Готов к воспроизведению")
//                        Player.STATE_ENDED -> Log.d("ExoPlayer", "Воспроизведение завершено")
//                        Player.STATE_IDLE -> Log.d("ExoPlayer", "Плеер бездействует")
//                    }
//                }
//
//                override fun onPlayerError(error: PlaybackException) {
//                    Log.e("ExoPlayer", "Ошибка воспроизведения: ${error.message}")
//                }
//            })
//        }
//    }
//
//    fun releasePlayer(exoPlayer: ExoPlayer?) {
//        exoPlayer?.release()
//    }
//
//}

//object ServiceLocator {
//
//    private val instances = mutableMapOf<KClass<*>, Any>()
//
//    inline fun <reified T: Any> register(instance: T) = register(T::class, instance)
//
//    fun <T: Any> register(kClass: KClass<T>, instance: T) {
//        instances[kClass] = instance
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    fun <T: Any> get(kClass: KClass<T>): T = instances[kClass] as T
//}
//
//inline fun <reified T: Any> locate() = ServiceLocator.get(T::class)
//
//inline fun <reified T: Any> locateLazy(): Lazy<T> = lazy {
//    ServiceLocator.get(T::class)
//}